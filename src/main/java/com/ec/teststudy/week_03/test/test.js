var assert  = require("assert"); //nodejs에서 제공하는 aseert 모듈
var chai = require('chai');

describe('province', function() {
    let asia;
    beforeEach(function(){
        asia = new Province(smapleProvinceData());

    });

    it('shortfall', function(){
        assert.equal(asia.shortfall,5)
    });

    it('profit', function(){
        chai.expect(asia.profit).equal(230)
    })

    it('change production', function(){
        asia.producers[0].production = 20;
        chai.expect(asia.shortfall).equal(-6);
        chai.expect(asia.profit).equal(292);
    });

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

// smapleProvinceData
function smapleProvinceData() {
    return {
        name: "Asia",
        producers: [
            {
                "name" : "Byzantium", cost: 10, production: 9
            },{
                "name" : "Attalia", cost: 12, production: 10
            },{
                "name" : "Sinope", cost: 10, production: 6
            },
        ],
        demand: 30,
        price: 20
    }
}


// Province.clss
class Province {
    constructor(doc) {
        this._name = doc.name;
        this._producers = [];
        this._totalProduction = 0;
        this._demand = doc.demand;
        this._price = doc.price;
        doc.producers.forEach(d => this.addProducer(new Producer(this, d)))
    }

    addProducer(arg){
        this._producers.push(arg)
        this._totalProduction += arg.production;
    }

    get name() {
        return this._name;
    }

    get producers() {
        return this._producers.slice();
    }

    get totalProduction() {
        return this._totalProduction;
    }

    set totalProduction(arg) {
        this._totalProduction = arg;
    }

    get demand() {
        return this._demand;
    }

    set demand(arg) {
        this._demand = parseInt(arg);
    }

    get price() {
        return this._price;
    }

    set price(arg) {
        this._price = parseInt(arg);
    }

    get shortfall() {
        return this._demand - this.totalProduction
    }

    get profit(){
        return this.demandValue - this.demandCost;
    }

    get demandValue() {
        return this.satisfiedDemand * this.price;
    }

    get satisfiedDemand() {
        return Math.min(this._demand, this.totalProduction);
    }

    get demandCost() {
        let remainingDemand = this.demand;
        let result = 0;
        this.producers
            .sort((a, b) => a.cost - b.cost)
            .forEach(p => {
                const contribution = Math.min(remainingDemand, p.production);
                remainingDemand -= contribution;
                result += contribution * p.cost;
            });
        return result;
    }

}
// Producer
class Producer {
    constructor(aProvince, data){
        this._province = aProvince;
        this._cost = data.cost;
        this._name = data._name;
        this._production = data.production || 0;
    }

    get name() {
        return this._name;
    }
    get cost() {
        return this._cost;
    }
    set cost(args) {
        this._cost = parseInt(args);
    }

    get production() {
        return this._production;
    }
    set production(amountStr) {
        const amount = parseInt(amountStr);
        const newProduction = Number.isNaN(amount) ? 0 : amount;
        this._province.totalProduction += newProduction - this._production;
        this._production = newProduction;
    }
}