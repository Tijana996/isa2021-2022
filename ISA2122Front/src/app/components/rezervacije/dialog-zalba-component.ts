import { ThrowStmt } from "@angular/compiler";
import { Component, Input, Inject } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { Rezervacija } from "src/app/models/rezervacija";
import { Zalba } from "src/app/models/zalba";
import { ZalbaService } from "src/app/services/zalba.service";

@Component({
  selector: "hello",
  template: `
    <div style="width:300px">
      <h2 mat-dialog-title>Zalba</h2>
      <form class="reactiveForm" [formGroup] = "zalbaForm" (submit) = "onSubmit()">
      <div mat-dialog-content>

      <p>Izaberite stranku na koju se zalite: </p>
      <section class="example-section">
      <mat-radio-group formControlName="tip">
        <mat-radio-button class="example-margin" value="VIKENDICA" [disabled]="vikendica">Vlasnik vikendice/Vikendica</mat-radio-button>
        <mat-radio-button class="example-margin" value="BROD" [disabled]="brod">Vlasnik broda/Brod</mat-radio-button>
        <mat-radio-button class="example-margin" value="INSTRUKTOR" [disabled]="instr">Instruktor pecanja</mat-radio-button>
      </mat-radio-group>
    </section>

      <p>Unesite obrazlozenje: </p>
      <mat-form-field class="full-width-input" appearance="fill">
                <mat-label>Obrazlozenje</mat-label>
                <textarea matInput placeholder="Unesite obrazlozenje" formControlName="obrazlozenje"></textarea>
            </mat-form-field>
      </div>
      <div mat-dialog-actions align="end">
        <span>
        <button
            type="button"
            mat-flat-button
            color="primary"
            type="submit"
            (click)="posaljiZalbu()"
          >
            Posalji
          </button>
        <button
        type="button"
        mat-stroked-button
        color="primary"
        (click)="CloseDialog()"
      >
        Izadji
      </button>
        </span>

        <mat-error name="errorRegister" *ngIf=wrong style="margin-top: 5%;">
            {{errorMessage}}
        </mat-error>    
        </div>
    </form>
      
    </div>
  `
})
export class DialogZalbaComponent {
  rezervacija: Rezervacija;
  zalbaForm: FormGroup;
  errorMessage: string;
  vikendica : boolean;
  brod : boolean;
  instr : boolean;
  wrong: boolean;
  zalba : Zalba;
  id : number;

  constructor(
    private _mdr: MatDialogRef<DialogZalbaComponent>,
    private fb: FormBuilder,
    private zalbaService : ZalbaService,
    @Inject(MAT_DIALOG_DATA) data: any
  ) {
    console.log(data)
    this.wrong = false; 
    this.zalbaForm = this.fb.group({
      'tip' :['VIKENDICA',Validators.required],
      'obrazlozenje' : ['']
    });

    this.rezervacija = data;
    this.id = data.id;
    this.vikendica = false;
    this.brod = false;
    this.instr = false;
    if (this.rezervacija.vikendice == null){
      this.vikendica = true;
    }
    if(this.rezervacija.brodovi == null){
      this.brod = true;
    }
    if(this.rezervacija.instruktor == null){
      this.instr = true;
    }
  }

  CloseDialog() {
    this._mdr.close(false)
  }

  onSubmit(){}

  posaljiZalbu(){
    this.zalba = new Zalba();
    this.zalba.tip = this.zalbaForm.controls['tip'].value;
    this.zalba.tekst = this.zalbaForm.controls['obrazlozenje'].value;
    this.zalba.idrezervacije = this.id;

    console.log(this.zalba);
      this.zalbaService.postZalba(this.zalba).subscribe( 
        result => {
          alert("Zalba je poslata na pregled!");
          this.CloseDialog();
        },        
        (err:Error) =>{
          this.errorMessage = err.message;
          this.wrong = true;
        });
  }
}
