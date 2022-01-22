import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Zalba } from '../models/zalba';

@Injectable({
  providedIn: 'root'
})
export class ZalbaService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  private readonly zalbaPath = 'http://localhost:8080/zalba';

  constructor(private http: HttpClient) { }

  postZalba(zalba : Zalba) : Observable<boolean>{
    let httpOptions = {};

    httpOptions = {
        headers: this.headers,
        observe: 'body',

    };

    return this.http.post<boolean>( this.zalbaPath + '/create', zalba, httpOptions);
}

answerZalba(zalba : Zalba) : Observable<boolean>{
  let httpOptions = {};

  httpOptions = {
      headers: this.headers,
      observe: 'body',

  };

  return this.http.post<boolean>( this.zalbaPath + '/answer', zalba, httpOptions);
}

getZalbe() : Observable<Zalba[]>{
  let httpOptions = {};

  httpOptions = {
      headers: this.headers,
      observe: 'body',

  };

  return this.http.get<Zalba[]>( this.zalbaPath, httpOptions);
}
}
