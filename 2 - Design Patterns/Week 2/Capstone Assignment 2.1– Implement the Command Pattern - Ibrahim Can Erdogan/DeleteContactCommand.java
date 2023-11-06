package com.ibrahimcanerdogan.sharingapp;

public class DeleteContactCommand implements Command {
    private ContactList contactList;
    private Contact contact;
    private Context context;

    public DeleteContactCommand(ContactList contactList, Contact contact, Context context) {
        this.contactList = contactList;
        this.contact = contact;
        this.context = context;
    }

    @Override
    public void execute() {
        contactList.deleteContact(contact);
        setIsExecuted(contactList.saveContacts(context));
    }
}
