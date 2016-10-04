/*

	submitpo.js
	- script for creating, submitting, and dynamically chaning the submit form
*/
var listsize = 0;	// keeps track of the number of elements in teh list

window.onload = function(){
	gatherProductInfo();	// on load setup first element
	document.getElementById("additem").addEventListener("click", gatherProductInfo());	// on additem click
//TODO
/*	document.getElementById("submit").addEventListener("click", listener);	//on submit
	document.getElementById("save").addEventListener("click", listener);	//on save
	document.getElementById("cancel").addEventListener("click", listener);	//on cancel
	
*/}

function addItem(){
	listsize++;	//increment list size
	var li = document.createElement("li");
	li.setAttribute("name", "lineitem"+listsize);

	//need to get product info from DB?
	var productMenu = createProductDropDown(productList);

	// create label for productMenu
	var productLabel  = document.createElement("label");
	productLabel.setAttribute("for", productMenu.getAttribute("name"));
	productLabel.innerHTML = "Product: ";

	// create QTY input box
	var qtyInput = document.createElement("input");
	qtyInput.setAttribute("type", "number");
	qtyInput.setAttribute("value", 0);
	qtyInput.setAttribute("name", "qty"+listsize);

	// create label for qtyInput
	var qtyLabel = document.createElement("label");
	qtyLabel.setAttribute("for", qtyInput.getAttribute("name"));
	qtyLabel.innerHTML = "Qty: ";
	
	// READONLY input field for price
	var priceInput = document.createElement("input");
	priceInput.setAttribute("readonly", true);
	priceInput.setAttribute("value", productList[0].unitPrice);
	priceInput.setAttribute("name", "price"+listsize);
	
	//create label for price field
	var priceLabel = document.createElement("label");
	priceLabel.setAttribute("for", priceInput.getAttribute("name"));
	priceLabel.innerHTML = "Price: ";
	
	//create REMOVE button
	var removeButton = document.createElement("button");
	removeButton.setAttribute("name", "remove"+listsize);
	removeButton.setAttribute("type", "button");
	removeButton.innerHTML = "Remove Item";
	
	//need to append all items to LI element
	li.appendChild(productLabel);
	li.appendChild(productMenu);
	li.appendChild(qtyLabel);
	li.appendChild(qtyInput);
	li.appendChild(priceLabel);
	li.appendChild(priceInput);
	li.appendChild(removeButton);
	
}

function createProductDropDown(productList){
	var product = document.createElement("select");
	product.setAttribute("name", "product"+listsize);

	//get options
	for(var i in productList ){
		product.appendChild(createOption(i))
	}	

	return product;
}

function createOption(product){
//	<option value="volvo">Volvo</option>
	var option = document.createElement("option");
	// need to populate option with items from product table
	option.setAttribute("value", product);
	option.innerHTML = product;
	return option;
}

function gatherProductInfo() {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		switch (xhr.readyState) {
		case 0:
		case 1:
		case 2:
		case 3:
			break;
		case 4:
			if(xhr.status === 200){
				//do stuff
				setProductValue(JSON.parse(xhr.responseText));
			}
			break;
		}
	}
	console.log("just before the products call");
	xhr.open("GET", "/IMS/getProducts", true);	//TODO 
	xhr.send();
}

function setProductValue(jProductList){
	addItem(jProductList);
}

