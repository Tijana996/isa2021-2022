import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { UserReg } from '../models/userregister';
import { JwtUtilsService } from './jwt-utils.service';

export interface AuthResponseData {
  id: string;
  accessToken: string;
  expiresIn: string;
}
export class User {
  constructor(
    private _token: string,
    private _tokenExpirationDate: Date
  ) {}

  get token() {
    if (!this._tokenExpirationDate || new Date() > this._tokenExpirationDate) {
      return null;
    }
    return this._token;
  }
}

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
    
  private readonly loginPath = 'http://localhost:8080/auth/login';
  private readonly registrationPath = 'http://localhost:8080/auth/sign-up';
  private readonly registerAdminPath = 'http://localhost:8080/auth/sign-up-admin';
  private readonly checkPredefinedPath = 'http://localhost:8080/auth/predefined';
  private readonly chanePasswordFirstLoginPath = 'http://localhost:8080/auth/first-login-password';
  private readonly confirmRegistrationPath = 'http://localhost:8080/auth/registration-confirm-owners';
  private readonly rejectRegistrationPath = 'http://localhost:8080/auth/registration-reject-owners';
  private readonly usersPath = 'http://localhost:8080/user';
 
  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient, private jwtUtilsService: JwtUtilsService, private jwtHelper : JwtHelperService) { }

  login(email: string, password: string) {
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post(this.loginPath, JSON.stringify({ email, password }), { headers }).pipe(
      map((res: any) => {
        let token = res && res['accessToken'];
        let id = res && res['id'];
        if (token) {
          localStorage.setItem('currentUser', JSON.stringify({
            id: id,
            username: email,
            roles: this.jwtUtilsService.getRoles(token),
            token: token
          }));
          console.log(localStorage);
          return true;
        }
        else {
          return false;
        }
      }))
      .pipe(catchError((error: any) => {
        if (error.status === 401) {
          return throwError('Illegal login');
        }
        else {
          return throwError('Server error');
        }
      }));
  }

  getToken(): String {
    var currentUser = JSON.parse(localStorage.getItem('currentUser') || '{}');
    //console.log(currentUser.username == null);
    var token = currentUser && currentUser.token;
    return token ? token : "";
  }

  logout(): void {
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    //console.log(localStorage.getItem('currentUser') );
    var currentUser = JSON.parse(localStorage.getItem('currentUser') || '{}');
    if(currentUser=="praviadmin@admin.com") {
      console.log("PROSLO");
      return false;
    }
    if (this.getToken() != '' ) return true;
    return false;
  }

  signup(user : UserReg){
    var headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<UserReg>(this.registrationPath, JSON.stringify(user), {headers}).pipe(
      map((res: any) => { return true; })).pipe(
        catchError((error: any) => {return throwError('Not created'); }));
  }

  getCurrentUser() {
    if (localStorage.currentUser) {
      return JSON.parse(localStorage.currentUser);
    }
    else {
      return undefined;
    }
  }

  signupAdmin(user : UserReg) : Observable<User> {
    let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.post<User>(
			this.registerAdminPath, user,
			httpOptions);		
  }

  getPasswordChange() : Observable<boolean> {
    let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.get<boolean>(
			this.usersPath + '/is_admin',
			httpOptions);		
  }

  changePassword(password : string) : Observable<boolean> {
    let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.post<boolean>(
			this.chanePasswordFirstLoginPath, password,
			httpOptions);		
  }

  getUser() : Observable<User> {
    let httpOptions = {};
    let id = JSON.parse(localStorage.getItem('currentUser') || "")?.id;

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.get<User>(
			this.usersPath + `/${id}`,
			httpOptions);		
  }
  
  getUserByUsername() : Observable<User> {
    let httpOptions = {};
    let email = JSON.parse(localStorage.getItem('currentUser') || "")?.username;
		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.get<User>(
			this.usersPath + `/profile/${email}`,
			httpOptions);		
  }

  checkIfPredefinisan() : Observable<boolean> {
    let httpOptions = {};
    let id = JSON.parse(localStorage.getItem('currentUser') || "")?.id;
		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.get<boolean>(
			this.checkPredefinedPath + `/${id}`,
			httpOptions);		
  }

  confirmRegistration(id : string) : Observable<User> {
    let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.get<User>(
			this.confirmRegistrationPath + `/${id}`,
			httpOptions);		
  }


  rejectRegistration(id : string) : Observable<User> {
    let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.get<User>(
			this.rejectRegistrationPath + `/${id}`,
			httpOptions);		
  }

  updateUser(user: User, username: string) : Observable<User> {
    let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.put<User>(
			this.usersPath + `/profile/${username}`,user,
			httpOptions);		
  }

  updateUser2(user: User, id: number) : Observable<User> {
    let httpOptions = {};

		httpOptions = {
			headers: this.headers,
			observe: 'body'
    	};
    
		return this.http.put<User>(
			this.usersPath + `/${id}`,user,
			httpOptions);		
  }
  

  public isAuthenticated(): boolean {
    const token = JSON.parse(localStorage?.getItem('currentUser') || "")?.token;
    // Check whether the token is expired and return
    // true or false
    return !this.jwtHelper.isTokenExpired(token);
  }

  

  public isAdmin(): any{
    return JSON.parse(localStorage.getItem('currentUser') || '{}');
  }

  public isKlijent(): any{
    var user = JSON.parse(localStorage.getItem('currentUser'));
    if(user == undefined) return false;
    return user.roles[0] == 'ROLE_KLIJENT' ? true : false;
  }


  public isPraviAdmin(): any{
    return JSON.parse(localStorage.getItem('currentUser') || '{}').username;
  }
}
