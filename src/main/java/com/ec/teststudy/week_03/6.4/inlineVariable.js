function foo_before(anOrder){
    let basePrice = anOrder.basePrice;
    return (basePrice > 1000);
}

function foo_after(anOrder){
    return anOrder.basePrice > 1000;
}