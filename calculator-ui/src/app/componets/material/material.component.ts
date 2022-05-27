import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {Material} from "../../models/material.model";
import {MaterialService} from "../../services/material.service";

@Component({
  selector: 'app-material',
  templateUrl: './material.component.html',
  styleUrls: ['./material.component.css']
})
export class MaterialComponent implements OnInit {

  form!: FormGroup;
  rows!: FormArray;
  number!: string;
  materials: Material[] = [];

  constructor(public materialService: MaterialService,
              private fb: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      rows : this.fb.array([])
    })

    this.materialService.getAll().subscribe((data) => {
        this.materials = data;

        this.materials.forEach( (material) => {
          const materialFrom = this.fb.group({
            id: material.id,
            name: material.name,
          })
          this.rows = this.form.get('rows') as FormArray;
          this.rows.push(materialFrom);
        })

      }
    );
  }
}
