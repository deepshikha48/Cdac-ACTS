export class MenuItem {
    constructor(
        public id: number,
        public itemName: string,
        public totalQuantity: number,
        public description: string,
        public price: number,
        public mealType: string,
        public day: string

    ) { }
}
