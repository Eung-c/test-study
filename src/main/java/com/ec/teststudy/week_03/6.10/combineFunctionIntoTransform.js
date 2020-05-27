function base(aReading) {/* */}
function taxableCharge(aReading) {/* */}

function enrichReding(argReading) {
    const aReading = _.cloneDeep(argReading);
    aReading.baseCharge = base(aReading);
    aReading.taxableCharge = taxableCharge(aReading);
    return aReading;
}