import matplotlib.pyplot as plt
from skimage import io, color, filters, morphology, measure
import numpy as np

def segment_cell(image):
    """
    Segment the blood cell from the image using grayscale thresholding and morphological operations.
    
    Parameters:
        image (ndarray): The input RGB image.
    
    Returns:
        segmented (ndarray): The segmented image with only the cell.
        mask (ndarray): The binary mask used for segmentation.
    """
    # Convert the image to grayscale
    gray_image = color.rgb2gray(image)
    
    # Compute Otsu's threshold
    thresh = filters.threshold_otsu(gray_image)
    
    # Create a binary mask: cells should be darker/brighter than background based on your images.
    # Adjust the condition (< or > thresh) as needed. Here we assume the cell is darker.
    mask = gray_image < thresh
    
    # Remove small objects (noise) from the binary image
    mask = morphology.remove_small_objects(mask, min_size=50)
    
    # Fill small holes in the cell region
    mask = morphology.remove_small_holes(mask, area_threshold=50)
    
    # Optional: Label connected regions and keep the largest region
    labels = measure.label(mask)
    if labels.max() != 0:
        # Find the largest connected component assuming it's the cell
        regions = measure.regionprops(labels)
        largest_region = max(regions, key=lambda r: r.area)
        # Create a mask for the largest region only
        mask = labels == largest_region.label

    # Apply the mask to the original image
    segmented = image.copy()
    segmented[~mask] = 0  # Set background pixels to black

    return segmented, mask