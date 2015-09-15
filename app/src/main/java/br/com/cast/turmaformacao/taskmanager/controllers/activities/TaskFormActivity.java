package br.com.cast.turmaformacao.taskmanager.controllers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.cast.turmaformacao.taskmanager.R;
import br.com.cast.turmaformacao.taskmanager.model.entities.Task;
import br.com.cast.turmaformacao.taskmanager.model.services.TaskBusinessService;
import br.com.cast.turmaformacao.taskmanager.util.FormHelper;

public class TaskFormActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextdescription;
    private Button buttonSave;
    private Task task;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        initTask();

        bindEditTextName();
        bindEditTextDescription();
        bindButtonSave();
    }

    private void initTask() {
        task = new Task();

    }


    private void bindButtonSave() {
        buttonSave = (Button) findViewById(R.id.buttonId);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String requiredMessage = TaskFormActivity.this.getString(R.string.msg_required);
                if (!FormHelper.validateRequired(requiredMessage, editTextName, editTextdescription)) {
                    binTask();
                    TaskBusinessService.getIntance().save(task);
                    Toast.makeText(TaskFormActivity.this, getString(R.string.msg_save_success), Toast.LENGTH_SHORT);
                    TaskFormActivity.this.finish();
                }

            }
        });
    }

    private void binTask() {
        task.setName(editTextName.getText().toString());
        task.setDescription(editTextdescription.getText().toString());
    }

    private void bindEditTextDescription() {
        editTextdescription = (EditText) findViewById(R.id.editTextDescription);
        editTextdescription.setText(task.getDescription() == null ? "" : task.getDescription());
    }

    private void bindEditTextName() {
        editTextName = (EditText) findViewById(R.id.editTextName);
    }

}
