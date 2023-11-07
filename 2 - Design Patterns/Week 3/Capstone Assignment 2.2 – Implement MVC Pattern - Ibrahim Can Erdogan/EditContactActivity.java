package com.ibrahimcanerdogan.sharingapp;

public class EditContactActivity extends AppCompatActivity implements Observer {

    private ContactList contact_list = new ContactList();
    private Contact contact;
    private EditText email;
    private EditText username;
    private Context context;

    private ContactController contactController = new ContactController(contact);
    private ContactListController contactListController = new ContactListController(contact_list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        context = getApplicationContext();
        contactListController.loadContacts(context);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);

        contact = contactListController.getContact(pos);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        username.setText(contactController.getUsername());
        email.setText(contactController.getEmail());
    }

    public void saveContact(View view) {

        String email_str = email.getText().toString();

        if (email_str.equals("")) {
            email.setError("Empty field!");
            return;
        }

        if (!email_str.contains("@")){
            email.setError("Must be an email address!");
            return;
        }

        String username_str = username.getText().toString();
        String id = contactController.getId(); // Reuse the contact id

        // Check that username is unique AND username is changed (Note: if username was not changed
        // then this should be fine, because it was already unique.)
        if (!contactListController.isUsernameAvailable(username_str) && !(contactController.getUsername().equals(username_str))) {
            username.setError("Username already taken!");
            return;
        }

        Contact updated_contact = new Contact(username_str, email_str, id);

        if(!contactListController.editContact(contact, updated_contact, context)) return;

        // End EditContactActivity
        finish();
    }

    public void deleteContact(View view) {
        if(!contactListController.deleteContact(contact, context))

            // End EditContactActivity
            finish();
    }
}