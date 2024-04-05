// function enlargeImage(image) {
//  image.classList.add("enlarged-image");
// }

// function restoreImage(image) {
//  image.classList.remove("enlarged-image");
// }

// Preload the hover images
// Get all the image elements on the page
const imageElements = document.querySelectorAll('img');

// Add event listeners for mouseover and mouseout to each image
imageElements.forEach(image => {
  // Get the original image source URL
  const originalSrc = image.src;

  // Get the data-hover attribute (contains the URL of the hover image)
  const hoverSrc = image.getAttribute('data-hover');

  // Preload the hover image
  const hoverImage = new Image();
  hoverImage.src = hoverSrc;

  // Add event listener for mouseover
  image.addEventListener('mouseover', () => {
    // Change the image source to the hover image URL
    image.src = hoverSrc;
  });

  // Add event listener for mouseout
  image.addEventListener('mouseout', () => {
    // Restore the original image source URL
    image.src = originalSrc;
  });
});
