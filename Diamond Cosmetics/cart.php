<?php
session_start(); // Start the session to store cart data

// Initialize the cart if it doesn't exist
if (!isset($_SESSION['cart'])) {
    $_SESSION['cart'] = array();
}

// Add item to the cart
if (isset($_POST['add_to_cart'])) {
    $product_name = $_POST['product_name'];
    $price = $_POST['price'];
    $quantity = $_POST['quantity'];

    // Check if the item is already in the cart
    if (array_key_exists($product_name, $_SESSION['cart'])) {
        // Item already exists, update quantity
        $_SESSION['cart'][$product_name]['quantity'] += $quantity;
    } else {
        // Item doesn't exist in the cart, add it
        $_SESSION['cart'][$product_name] = array(
            'price' => $price,
            'quantity' => $quantity
        );
    }
}

// Remove item from the cart
if (isset($_POST['remove_from_cart'])) {
    $product_name = $_POST['product_name'];
    unset($_SESSION['cart'][$product_name]);
}

// Clear the entire cart
if (isset($_POST['clear_cart'])) {
    $_SESSION['cart'] = array();
}

?>