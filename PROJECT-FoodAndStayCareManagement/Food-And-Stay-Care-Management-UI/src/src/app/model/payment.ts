export class Payment {
    constructor(
        public ownerName: string,
        public cardNumber: string,
        public expiryDate: Date,
        public cvv: string,
    ) { }
}
