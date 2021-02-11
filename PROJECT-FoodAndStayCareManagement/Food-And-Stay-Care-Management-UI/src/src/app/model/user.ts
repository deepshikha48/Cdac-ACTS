export class User {
    constructor(
        public id: number,
        public firstName: string,
        public lastName: string,
        public email: string,
        public contact: string,
        public password: string,
        public role: any
    ) { }
}
