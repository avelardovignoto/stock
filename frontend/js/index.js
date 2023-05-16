const table = document.querySelector("#table");
const tbody = document.querySelector("#data-products");
const previousButton = document.querySelector("#previous-page-button");
const nextButton = document.querySelector("#next-page-button");
const pagination = document.querySelector(".pagination");

const pageSize = 3;
let pageNumber = 1;
let totalPages = 0;

const updatePagination = () => {
    pagination.innerHTML = `Página ${pageNumber} de ${totalPages}`;
};

nextButton.addEventListener("click", () => {
    if(pageNumber < totalPages ) {
        pageNumber++;
        searchProducts(pageNumber, pageSize);
        previousButton.disabled = false;  
    }

    if (pageNumber === totalPages) {
        nextButton.disabled = true;
    }
});

previousButton.addEventListener("click", () => {
    if (pageNumber > 1) {
        pageNumber--;
        searchProducts(pageNumber, pageSize);
        nextButton.disabled = false;
    }

    if (pageNumber === 1) {
        previousButton.disabled = true;
    }
});

const searchProducts = async (pageNumber, pageSize) => {
    const url = `http://localhost:8080/api/v1/products?page=${pageNumber}&size=${pageSize}`;
    const options = {headers: {'Accept': 'application/json'},  method: 'GET' }

    const response = await fetch(url, options);
    const productsData = await response.json();

    tbody.innerHTML = "";

    const startIndex = (pageNumber - 1) * pageSize;
    const endIndex = startIndex + pageSize;
    const products = productsData.slice(startIndex, endIndex);

    totalPages = Math.ceil(productsData.length / pageSize);
    updatePagination();

    listingProducts(products);
}

const listingProducts = products => {
    products.map(product => {
        const tr = document.createElement("tr");
    
        const code = document.createElement("td");
        code.textContent = product.code;
        tr.appendChild(code);
    
        const productName = document.createElement("td");
        productName.textContent = product.productName;
        tr.appendChild(productName);
    
        const quantity = document.createElement("td");
        quantity.textContent = product.quantity;
        tr.appendChild(quantity);
    
        const supplier = document.createElement("td");
        supplier.textContent = product.supplier;
        tr.appendChild(supplier);
    
        const createdAt = document.createElement("td");
        createdAt.textContent = product.createdAt;
        tr.appendChild(createdAt);
    
        tbody.appendChild(tr);
        
    });
}

searchProducts(pageNumber, pageSize);