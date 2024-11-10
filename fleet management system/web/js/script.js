// Mobile Menu Handling
const menuToggle = document.querySelector('.menu-toggle');
const sidebar = document.querySelector('.sidebar');
const mainContent = document.querySelector('.main-content');
let isMobile = window.innerWidth < 1024;

// Responsive Handler
function handleResponsive() {
    isMobile = window.innerWidth < 1024;
    if (!isMobile && sidebar.classList.contains('active')) {
        sidebar.classList.remove('active');
    }
}

// Event Listeners
window.addEventListener('resize', handleResponsive);
window.addEventListener('orientationchange', handleResponsive);

menuToggle.addEventListener('click', () => {
    sidebar.classList.toggle('active');
});

// Close sidebar when clicking outside on mobile
document.addEventListener('click', (e) => {
    if (isMobile && 
        !e.target.closest('.sidebar') && 
        !e.target.closest('.menu-toggle') && 
        sidebar.classList.contains('active')) {
        sidebar.classList.remove('active');
    }
});

// Touch Events for Mobile
let touchStartX = 0;
let touchEndX = 0;

document.addEventListener('touchstart', (e) => {
    touchStartX = e.changedTouches[0].screenX;
});

document.addEventListener('touchend', (e) => {
    touchEndX = e.changedTouches[0].screenX;
    handleSwipeGesture();
});

function handleSwipeGesture() {
    const swipeDistance = touchEndX - touchStartX;
    const threshold = 100; // minimum swipe distance

    if (Math.abs(swipeDistance) > threshold) {
        if (swipeDistance > 0 && !sidebar.classList.contains('active')) {
            // Swipe right - open sidebar
            sidebar.classList.add('active');
        } else if (swipeDistance < 0 && sidebar.classList.contains('active')) {
            // Swipe left - close sidebar
            sidebar.classList.remove('active');
        }
    }
}

// Responsive Grid Layout
function updateGridLayout() {
    const vehiclesGrid = document.querySelector('.vehicles-grid');
    const width = window.innerWidth;
    
    if (width < 768) {
        vehiclesGrid.style.gridTemplateColumns = '1fr';
    } else if (width < 1024) {
        vehiclesGrid.style.gridTemplateColumns = 'repeat(2, 1fr)';
    } else if (width < 1440) {
        vehiclesGrid.style.gridTemplateColumns = 'repeat(3, 1fr)';
    } else {
        vehiclesGrid.style.gridTemplateColumns = 'repeat(4, 1fr)';
    }
}

// Responsive Modal
function updateModalPosition() {
    const modal = document.querySelector('.modal');
    if (!modal) return;

    const modalContent = modal.querySelector('.modal-content');
    const windowHeight = window.innerHeight;
    const modalHeight = modalContent.offsetHeight;

    if (modalHeight > windowHeight * 0.9) {
        modalContent.style.height = '90vh';
        modalContent.style.overflow = 'auto';
    } else {
        modalContent.style.height = 'auto';
    }
}

// Responsive Charts
function resizeCharts() {
    const chartContainers = document.querySelectorAll('.chart-container');
    chartContainers.forEach(container => {
        const parent = container.parentElement;
        const chart = container.querySelector('canvas');
        if (chart) {
            chart.style.width = '100%';
            chart.style.height = parent.offsetHeight + 'px';
        }
    });
}

// Debounce function for performance
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

// Responsive Event Listeners
window.addEventListener('resize', debounce(() => {
    updateGridLayout();
    updateModalPosition();
    resizeCharts();
}, 250));

// Initialize Responsive Features
function initResponsive() {
    handleResponsive();
    updateGridLayout();
    updateModalPosition();
    resizeCharts();
}

// Call on page load
document.addEventListener('DOMContentLoaded', initResponsive);

// Handle image loading responsively
function handleResponsiveImages() {
    const images = document.querySelectorAll('img[data-src]');
    images.forEach(img => {
        const windowWidth = window.innerWidth;
        let src = img.getAttribute('data-src');
        
        // Choose appropriate image size based on screen width
        if (windowWidth <= 768) {
            src = src.replace('large', 'small');
        } else if (windowWidth <= 1024) {
            src = src.replace('large', 'medium');
        }
        
        img.src = src;
    });
}

// Lazy loading for performance
if ('IntersectionObserver' in window) {
    const imageObserver = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const img = entry.target;
                handleResponsiveImages();
                observer.unobserve(img);
            }
        });
    });

    document.querySelectorAll('img[data-src]').forEach(img => {
        imageObserver.observe(img);
    });
}
