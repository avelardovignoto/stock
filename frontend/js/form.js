const form = document.querySelector("#form");

form.addEventListener('submit', e => {
    e.preventDefault();

    const product = {
        productName: e.target.productName.value,
        quantity: e.target.quantity.value,
        supplier: e.target.supplier.value
    }
    
    form.reset();

    registerProduct(product);
})

const registerProduct = product => {
    const url = 'http://localhost:8080/api/v1/products';
    const options = {
        headers: { 'Content-Type': 'application/json' },
        method: 'POST',
        body: JSON.stringify(product)
    }

    fetch(url, options);
}