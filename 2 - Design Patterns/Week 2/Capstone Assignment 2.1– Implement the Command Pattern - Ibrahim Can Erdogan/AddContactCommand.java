package com.ibrahimcanerdogan.sharingapp;

public class AddContactCommand extends Command {
    private ContactList contactList;
    private Contact contact;
    private Context context;

    public AddContactCommand(ContactList contactList, Contact contact, Context context) {
        this.contactList = contactList;
        this.contact = contact;
        this.context = context;
    }

    @Override
    public void execute() {
        contactList.addContact(contact);
        setIsExecuted(contactList.saveContacts(context));
    }
}