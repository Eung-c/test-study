const orderData = orderString.split(/\s+/);
const productPrice = priceList[orderData[0].split("-")[1]];
const orderPrice = parseInt(orderData[1]) * productPrice;

////////////////////////////////////////////////////////////////////////////

const orderRecord = parseOrder(order);
const productPrice = price(orderRecord, priceList);

function parseOrder(aString){
    const values = aString.split(/\s+/);
    return({
        productID: values[0].split("-")[1],
        quantitiy: parseInt(values[1])
    });
}

function price(order, priceList){
    return order.quantitiy * priceList[order.productID];
}