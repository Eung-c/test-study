function printOwing_before(invoice){
    invoice.customer = '로직~1';
    let outstanding = 3434;

    // 세부사항 출력
    console.log('고객명 : ${invoice.customer}');
    console.log('채무액 : ${outstanding}');
}


function printOwing_after(invoice){
    invoice.customer = '로직~1';
    let outstanding = 3434;

    function printDetails(outstanding){
        // 세부사항 출력
        console.log('고객명 : ${invoice.customer}');
        console.log('채무액 : ${outstanding}');
    }
}