import { Component, Input, Inject } from "@angular/core";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";

@Component({
  selector: "hello",
  template: `
    <div style="width:300px">
      <h2 mat-dialog-title>Obrazlozenje</h2>
      <div mat-dialog-content>{{ name }}</div>
      <div mat-dialog-actions align="end">
        <span>
        <button
        type="button"
        mat-stroked-button
        color="primary"
        (click)="CloseDialog()"
      >
        Izadji
      </button>
        </span>
      </div>
    </div>
  `
})
export class DialogComponent {
  name: string;
  constructor(
    private _mdr: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) data: string
  ) {
      console.log(data)
    this.name = data;
  }
  CloseDialog() {
    this._mdr.close(false)
  }
}
