export class UserProfile { //id,email, lozinka, poeni, kategorija, penali, enabled, token_id, type, ime, prezime, adresa, grad, drzava, broj
    email: string;
    password : string;
    ime : string;
    prezime : string;
    adresa : string;
    grad : string;
    drzava : string;
    broj : string;
    poeni: number;
    kategorija : string;
    penali : number;

    constructor(){}
}