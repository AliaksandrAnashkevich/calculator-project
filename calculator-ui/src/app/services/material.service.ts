import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Material} from "../models/material.model";

@Injectable({
  providedIn: 'root'
})
export class MaterialService {

  private readonly baseUrl: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/material';
  }

  getById(id: number): Observable<Material> {
    return this.http.get<Material>(`${(this.baseUrl)}/${id}`);
  }

  getAll(): Observable<Material[]> {
    return this.http.get<Material[]>(this.baseUrl);
  }

  add(material: Material): Observable<Material> {
    return this.http.post<Material>(this.baseUrl, material);
  }

  update(id: number, material: Material): Observable<Material> {
    return this.http.put<Material>(`${this.baseUrl}/${id}`, material);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
