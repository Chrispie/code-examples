import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Token} from "./app.model";
import {JwtHelperService} from "@auth0/angular-jwt";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: []
})
export class AppComponent {

    private access_token: string;
    private helper = new JwtHelperService();
    private errorMsg: string = '';

    private response: string;

    constructor(private httpClient: HttpClient) {
    }

    /**
     * Call the service with hardcoded values to get the JWT token
     */
    callOAuthServer() {
        const loginUrl = "http://localhost:8085/oauth/token"
        const clientId = "test";
        const clientSecret = "test";
        const username = "john@gmail.com";
        const password = "password";

        let headers = new HttpHeaders();
        headers = headers.set('Authorization', 'Basic ' + btoa(`${clientId}:${clientSecret}`));
        headers = headers.set('Accept', 'application/json');
        headers = headers.set('Content-Type', 'application/x-www-form-urlencoded');

        const data = `grant_type=password&username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`;

        this.httpClient.post<Token>(loginUrl, data, {headers: headers})
            .subscribe(
                (res: Token) => {
                    //store it on the front end to pass along
                    this.access_token = res.access_token;
                }, error => {
                    this.errorMsg = error.message;
                }
            );
    }

    //Try to call the REST Controller
    callResourceServer() {
        let headers = new HttpHeaders();
        headers = headers.set('Content-Type', 'text/html');
        headers = headers.set('Authorization', "Bearer " + this.access_token);  //Add the auth header with Bearer and the token

        const httpOptions = {headers: headers};
        this.httpClient.get("http://localhost:9091/dummy1", httpOptions)
            .subscribe(
                (res) => {
                    //Log to the console and front end
                    console.log(res);
                    this.response = res.toString();
                }, error => {
                  this.errorMsg = error.message;
                }
            )
    }
}
