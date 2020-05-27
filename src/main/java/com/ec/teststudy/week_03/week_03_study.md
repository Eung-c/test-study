# 4. 테스트 구축
## 4.1. 자가 테스트 코드의 가치
* 버그를 수정 하는건 대부분 빠르게 끝남 -> 찾는 시간이 오래 걸림
* 버그를 위해 테스트 코드를 작성
* 하지만 테스트 코드를 작동 시키는 것도 개발자가 해야할 일 -> 일이 늘어남
* 소스코드를 빌드하면 스스로 동작해서 결과를 내놓는 테스트 코드가 필요해짐
> 모든 테스트를 완전히 자동화하고 그 결과까지 스스로 검사하게 만들자
* 여전히 잘 동작하는지 보장하기 편해짐 (회귀 버그가 없어짐)
* 테스트를 시작하기 가장좋은 시점 : 프로그래밍을 시작하기 전



## 4.2. 테스트 샘플 코드
* 올려두겠음 설정해서 돌려보시오


## 4.3. 첫 번째 테스트
```
describe('province', function() {
    it('shortfall', function(){
        const asia = new Province(smapleProvinceData());
        assert.equal(asia.shortfall,5)
    });
});
```
> 실패해야 할 상황에서는 반드시 실패하게 만들자
* 테스트가 어떤 조건에서도 성공할 수도 있음 -> 실패 case를 만들어 테스트가 정상 동작하는지 확인해봐야함

## 4.4. 테스트 추가하기 & 4.5. 픽스처 수정하기

```
describe('province', function() {
    let asia;
    beforeEach(function(){ 
        // 공통 사용 변수를 초기화
        // 픽스처를 새로 만들면 독립적으로 구성 완료
        // 설정, 조건 또는 준비
        asia = new Province(smapleProvinceData());
    });
    
    it('shortfall', function(){
        assert.equal(asia.shortfall,5)
    });

    it('profit', function(){
        chai.expect(asia.profit).equal(230)
    })

    it('change production', function(){
        asia.producers[0].production = 20; // 실행, 발생 또는 수행
        chai.expect(asia.shortfall).equal(-6); // 검증, 결과 또는 단언
        chai.expect(asia.profit).equal(292); // 검증, 결과 또는 단언
    });
});
```
* 이런 패턴을 보통 '설정-시행-검증', '조건-발생-결과', '준비-수행-단언' 라고 부른다. 위 코드에서는 공통 픽스처 설정이 '설정, 조건 또는 준비'에 해당한다.

## 4.6. 경계 조건 검사하기
* 대부분 테스트는 꽃길 또는 행복경로 테스트만 수행한다 -> 인터페이스 검토를 위해 이런 행복경로 테스트만 실행해도 된다는 의견도 있다.
* 경계 테스트 예시

```

describe('province', function() {
    let asia;
    beforeEach(function(){
        asia = new Province(smapleProvinceData());

    });
    ...
    it('zeor demand', function(){
        asia.demand = 0;
        chai.expect(asia.shortfall).equal(-25);
        chai.expect(asia.profit).equal(0);
    });

    it('negative demand', function(){
        asia.demand = -1;
        chai.expect(asia.shortfall).equal(-26);
        chai.expect(asia.profit).equal(-10);
    });
 
});

describe('no producers', function() {
    let noProducers;
    beforeEach(function(){
        const data = {
            name: "No producers", 
            producers: [],
            demand: 30,
            price: 20
        };

        noProducers = new Province(data);
    });

    it('shortfall', function(){
        chai.expect(noProducers.shortfall).equal(30);
    });
    
    it('priofit', function(){
        chai.expect(noProducers.profit).equal(0);
    });
})
```

> 어차피 모든 버그를 잡아낼 수는 없다고 생각하여 테스트를 작성하지 않는다면 대다수의 버그를 잡을 수 있는 기회를 날리는 셈이다.
* 테스트를 너무 작성하다보면 의욕이 떨어짐 -> 수정이 많이 일어나고 크리티컬한 곳을 중점으로 먼저 작성


## 4.7.
> 버그 리포트를 받으면 그 버그를 드러내는 단위 테스트 부터 작성

# 5. 리팩터링 카탈로그 보는법
* 이건 넘어감 그냥 6장 이후에 나오는 책 읽는 법 설명 파트임

# 6. 기본적인 리팩터링
## 6.1. 함수 추출하기(메서드 추출)
* 반대 리팩터링 : 함수 인라인하기
``` 6.1/extractFunction.js
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
```
### 배경
* '목적과 구현을 분리' 방법으로 함수 추출
    * 코드를 파악하는데 한참 걸린다.
    * 그 부분을 함수로 추출
    * '무슨 일' 에 걸맞는 이름을 지음
    * 이름을 통해 목적을 나타낼 수 있음 -> 수정시 불필요한 코드(구현)를 파악할 필요가 없음
* 결국 함수를 짧게 짤 수록 목적을 나타내기 쉬움
* 함수를 짧게 만들면 성능 이슈가 걱정? -> 함수 캐싱이 쉬워져 최근에는 더욱 빠른 속도를 낼 수도 있음
### 절차
1. 함수를 새로 만들고 목적을 잘 드러내는 이름을 붙인다.
2. __추출할 코드를 원본 함수에서 복사하여 새 함수에 붙여 넣는다.__
3. 추출한 코드 중 원본 함수의 지역변수를 참조하거나 유효 범위를 벗어나는 함수가 없는지 확인 한다.
4. 변수를 처리했다면 컴파일
5. 원본 함수에서 추출한 코드 부분을 새로 만든 함수를 호출한는 문장으로 바꾼다.
6. __테스트 한다.__
7. 다른 곳에도 동일한 일을 하는 부분들을 찾아 바꾼다.

## 6.2. 함수 인라인하기(메서드 내용 직접 삽입)
* 반대 리팩터링 : 함수 추출하기
```6.2/inlineFunction.js
function getRating_before(driver){
    return moreThanFiveLateDeliveries(driver) ? 2 : 1;
}

function moreThanFiveLateDeliveries(driver){
    return driver.numberOfLateDeliveries > 5;
}


function getRating_after(driver){
    return( driver.numberOfLateDeliveries > 5) ? 2 : 1;
}
```

### 배경 
* 때로는 함수 본문(구현) 자체가 함수 이름만큼 명확한 경우도 있다.
* 이럴 때는 오히려 간접 호출이 거슬린 뿐이다.

### 절차
1. 다형 메서드 인지 확인한다 -> 서브 클래스에서 오버라이드 하는 메서드는 인라인 X
2. 인라인 함수 호출하는 곳을 모두 찾는다.
3. 각 호출문을 함수 본문으로 교체
4. 교체 할때마다 테스트 실행
5. 기존 함수 정의 삭제

* 인라인을 하면 구조가 복잡해 지는 경우 금지


## 6.3. 변수 추출하기 (직관적 임시변수 사용)
* 반대 리팩터링 : 변수 인라인하기
```6.3/extractVariable.js
function foo_before(order){
    return order.quantity * order.itemPrice - 
        Math.max(0, order.quantity - 500) * order.itemPrice * 0.05 +
        Math.min(order.quantity * order.itemPrice * 0.1, 100);
}

function foo_after(order){
    const basePrice = order.quantity * order.itemPrice;
    const quantityDiscount = Math.max(0, order.quantity - 500) * order.itemPrice * 0.05;
    const shipping =  Math.min(order.quantity * order.itemPrice * 0.1, 100);

    return basePrice - quantityDiscount + shipping;
}
```
### 배경
* 표현식이 너무 복잡
* 로직을 구성하는 단계에 이름을 붙여 목적을 드러내기 쉬움
* 디버깅 편함
* 추출할 변수의 이름이 함수를 벗어나 넓은 문맥까지 의미를 가진다면 함수로 추출

### 절차
1. 추출하려는 표현식에 부작용 판단.
2. 불변 변수를 하나 선언하고 이름을 붙일 표현식 복제본을 대입
3. 원본 표현식을 새로 만든 변수로 교체
4. 테스트
5. 표현식을 여러 곳에서 사용 한다면 각각을 새로 만든 변수로 교체, 그 때마다 테스트

## 6.4. 변수 인라인하기 (임시변수 내용 직접 삽입)
* 반대 리팩터링 : 변수 추출하기
``` 6.4/inlineVariable.js
function foo_before(anOrder){
    let basePrice = anOrder.basePrice;
    return (basePrice > 1000);
}

function foo_after(anOrder){
    return anOrder.basePrice > 1000;
}
```
### 배경
* 변수와 표현식 차이가 없을때
* 주변 코드 리팩터링에 방해가 될때


## 6.5. 함수 선언 바꾸기(함수 이름 바꾸기 / 시그니처 바꾸기 / 메서드명 변경 / 매개변수 추가 / 매게변수 제거)

```
function foo(redius) {...}

function bar(redius) {...}
```
### 배경
* 함수의 인터페이스 선언은 구성요소를 조립하는 중요한 역할 및 수단이다.
* 가장 중요한 요소중 하나는 이름이다.
    * 호출문만 보고도 역할을 알 수 있어야 한다.
    * 이름을 잘 지어야 이후 유지보수에 편한다.
* 매개변수도 마찬가지로 동작 방식을 정의한다.
    * 가급적 유연하며 문맥상 알맞는 매개변수를 받아야 한다.
    * 매개변수를 선택하는 기준이란?
    * 캡슐화 <-> 공통 사이에서 고민
    * 꾸준한 리팩터링으로 맞는 방법을 찾아가야함

### 절차
* 간단한 절차 : 패스
1. 함수 본문을 새로운 함수로 추출
2. 테스트
3. 기존 함수를 인라인 한다.
4. 테스트

* 함수 이름 바꾸기 (간단 / 마이그)
* 매개변수 추가
* 매개변수를 속성으로 바꾸기


## 6.6. 변수 캡슐화 하기(필드 자체 캡슐화, 필드 캡슐화)
``` 6.6/encapsulateVariable.js
let defaultOwner = {firstNmae: "마틴", lastName: "파울러"};

export function defaultOwner(){
    return defaultOwner;
}

export function setDefaultOwner(arg){
    defaultOwner = arg;
}
```
### 배경
1. 전역 데이터 및 접근범위가 넓은 데이터는 다루기가 어려움
2. 해당 데이터에 접근하는 통로를 좁혀 감시나 제약을 두기 쉬워짐
3. 불변 데이터는 변경이 불가능하여 복제하여 쓸수밖에 없음 -> 아주 좋은 상황

### 절차
1. 변수로의 접근/갱신을 전담하는 캡슐 함수 생성
2. 직접 참조 부분을 접근 함수 호출롭 변경
3. 테스트
4. 변수 접근범위 수정
5. 테스트

## 6.7. 변수 이름 바꾸기
```
let a = height * width;

let area = height * width;
```
### 배경
1 .명확한 이름!
 
## 6.8. 매개변수 객체 만들기
```
function amountInvoiced_before(startData, endDate){/* */}
function amountReceived_before(startData, endDate){/* */}
function amountOverdue_before(startData, endDate){/* */}

function amountInvoiced_after(aDateRange){/* */}
function amountReceived_after(aDateRange){/* */}
function amountOverdue_after(aDateRange){/* */}
```
### 배경
* 데이터 뭉치를 데이터 구조로 묶으면 데이터 사이의 관계가 명확해짐(데이터 응집도)
* 일관성을 높여줌
* 데이터와 행위를 합쳐 클래스로 만들기도 가능

### 절차
1. 적당한 데이터 구조가 아직 마련되어 있지 않다면 새로 만듬
2. 테스트
3. 함수 선언 바꾸기로 새 데이터 구조를 매개변수로 추가
4. 테스트
5. 함수 호출 시 새로운 데이터 구조 인스턴스를 넘기도록 수정한다.
6. 기존 매개변수를 사용하던 코드를 데이터 구조를 사용하도록 변경
7. 기존 매개변수를 제거하고 테스트

## 6.9. 여러 함수를 클래스로 묶기
```6.9/combineFunctionIntoClass.js
function base(aReading) {/* */}
function taxableCharge(aReading) {/* */}
function calculateBaseCharge(aReading) {/* */}

class Reading {
    base() {/* */}
    taxableCharge() {/* */}
    calculateBaseCharge() {/* */}
}
```

## 배경
* 공통 데이터를 중심으로 긴밀하게 동작하는 함수 무리를 하나의 환경으로 묶을 수 있음
* 이러한 공유 환경에 대한 참조를 제공할 수 있음

## 절차
1. 함수들이 공유하는 데이터를 캡슐화
2. 공유 데이터를 사용하는 함수를 클래스로 이동
3. 데이터를 조작하는 로직 및 접근/감시 기능들을 함수로 추출해 새 클래스로 옮김

## 6. 10. 여러 함수를 변환 함수로 묶기
```6.10/combineFunctionIntoTransform.js
function base(aReading) {/* */}
function taxableCharge(aReading) {/* */}

function enrichReding(argReading) {
    const aReading = _.cloneDeep(argReading);
    aReading.baseCharge = base(aReading);
    aReading.taxableCharge = taxableCharge(aReading);
    return aReading;
}
```

## 배경
* 데이터를 받아 도출하는 로직 중복이 생기는 경우가 많음
* 원본 데이터의 변경 유무에 따라 클래스 묶기로 변경 가능

## 6.11. 단계 쪼개기
```6.11/splitPhase.js
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
```

### 배경
* 서로 사용되는 곳이 다른 값들을 뒤섞어 가며 다루는 코드가 있음
* 해당 로직들을 모듈로 나눔
* 입력 데이터를 이후 다루기 편한 데이터로 변경하는로직을 선행 하기도 함

### 절차
* 단계를 추출하고 중간 데이터 구조를 만들어 다음 단계 함수에 전달



