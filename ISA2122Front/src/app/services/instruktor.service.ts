import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { JwtUtilsService } from './jwt-utils.service';

@Injectable({
  providedIn: 'root'
})
export class InstruktorService {

  

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  private readonly newsPath = 'http://localhost:8080/instruktori';

  constructor(private http: HttpClient) { }

  getInstruktori() : Observable<any>{
      let httpOptions = {};

      httpOptions = {
          headers: this.headers,
          observe: 'response',

      };

      return this.http.get<any>( this.newsPath, httpOptions);
  }

  getInstruktor(id) : Observable<any>{
    let httpOptions = {};

    console.log(id);
    httpOptions = {
        headers: this.headers,
        observe: 'response',

    };

    return this.http.get<any>( this.newsPath+'/'+id, httpOptions);
  }

  
  getInstruktorSearch(s1,s2,s3,s4): Observable<any>{
    let httpOptions = {};

    httpOptions = {
        headers: this.headers,
        observe: 'body',
        //data : search
    };

    return this.http.post<any>( this.newsPath+'/search/',JSON.stringify({ s1,s2,s3,s4 }), httpOptions);
  }
}
