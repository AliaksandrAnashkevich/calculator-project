import {Component, OnInit} from '@angular/core';
import {Material} from "../../models/material.model";
import {FormGroup, FormControl, Validators, FormBuilder, FormArray} from '@angular/forms';
import {CalculateService} from "../../services/calculate.service";

@Component({
  selector: 'app-calculate',
  templateUrl: './calculate.component.html',
  styleUrls: ['./calculate.component.css']
})
export class CalculateComponent implements OnInit {

  form!: FormGroup;
  rows!: FormArray;
  number!: string;
  materials: Material[] = [];

  constructor(public calculateService: CalculateService,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      rows : this.fb.array([])
    })

    this.calculateService.getAll().subscribe((data) => {
        this.materials = data;

      this.materials.forEach( (material) => {
        const calculateForm = this.fb.group({
          id: material.id,
          name: material.name,
          range: material.range,
          temperature: 0,
          resistance: 100,
          answer : 0
        })
          this.rows = this.form.get('rows') as FormArray;
          this.rows.push(calculateForm);
      })

      }
    );
  }

  count(i: number): void {
    const id = this.rows.controls[i].value.id;
    const t = this.rows.controls[i].value.temperature;
    const r = this.rows.controls[i].value.resistance;

    this.calculateService.count({id, t, r}).subscribe((data) => {
      this.rows.controls[i].value.answer = data;
    })
  }

}
