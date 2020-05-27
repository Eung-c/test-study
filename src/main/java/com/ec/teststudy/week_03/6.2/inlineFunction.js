function getRating_before(driver){
    return moreThanFiveLateDeliveries(driver) ? 2 : 1;
}

function moreThanFiveLateDeliveries(driver){
    return driver.numberOfLateDeliveries > 5;
}


function getRating_after(driver){
    return( driver.numberOfLateDeliveries > 5) ? 2 : 1;
}