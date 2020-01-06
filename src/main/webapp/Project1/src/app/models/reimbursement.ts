import { User } from './user';

export class Reimbursement {
    id : number;
    amount : number;
    submitted : string;
    resolved : string;
    description : string;
    receipt : File;
    author : User;
    resolver : User;
    status : string;
    type : string;

}
