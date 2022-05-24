import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Observable} from "rxjs";
import {Material} from "../models/material.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class CalculateService {

  private readonly baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/calculate';
  }

  getAll(): Observable<Material[]> {
    return this.http.get<Material[]>(this.baseUrl);
  }

  count(request: any): Observable<any> {
    const params = request;
    return this.http.get(`${this.baseUrl}/count`, {params});
  }
}
