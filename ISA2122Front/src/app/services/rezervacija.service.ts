import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Observable } from 'rxjs';
import { Rezervacija } from '../models/rezervacija';
import { JwtUtilsService } from './jwt-utils.service';

@Injectable({
  providedIn: 'root'
})
export class RezervacijaService {  

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  private readonly newsPath = 'http://localhost:8080/rezervacija';

  constructor(private http: HttpClient) { }

  addRezervacija(rezervacija: Rezervacija): Observable<Rezervacija> {
		let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body',
		};

		return this.http.post<Rezervacija>(
			this.newsPath, 
			rezervacija, httpOptions);
	}

	getRezervacije(id) : Observable<any>{
		let httpOptions = {};
  
		httpOptions = {
			headers: this.headers,
			observe: 'response',
  
		};
  
		var currentUser = JSON.parse(localStorage.getItem('currentUser') || '{}');

		var ind = id==1? 0 :currentUser.id
		console.log(ind);
		return this.http.get<any>( this.newsPath+'/'+ind, httpOptions);
	}
  
}
