package com.saki.authort;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.IOException;

public class AuthorAccunt implements Externalizable {
    public long id;
    public String key = "";
    public long time;

    public void readExternal(ObjectInput objectInput) throws IOException {
        this.id = objectInput.readLong();
        this.time = objectInput.readLong();
        this.key = objectInput.readUTF();
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeLong(this.id);
        objectOutput.writeLong(this.time);
        objectOutput.writeUTF(this.key);
    }
}
