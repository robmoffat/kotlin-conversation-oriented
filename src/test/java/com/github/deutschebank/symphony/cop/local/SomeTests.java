package com.github.deutschebank.symphony.cop.local;

import com.github.deutschebank.symphony.cop.Conversation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SomeTests {


    @Test
    public void sendMessage() {
        LocalAddressSpace las = new LocalAddressSpace();
        Conversation c1 = las.getConversation("Convo 1", new HashSet<>(), new HashMap<>());
        BasicTag t1 = new BasicTag("tag", "bob");
        BasicTag t2 = new BasicTag("tag", "doug");
        String text = "This is a test message";
        c1.post(new TextMessage(c1, text, Arrays.asList(t1)));

        // ok, can we return with filter?
        Assert.assertEquals(text, ((TextMessage) c1.getLast(m -> m.only(BasicTag.class).contains(t1))).getText());

        // check the null case
        Assert.assertEquals(null, ((TextMessage) c1.getLast(m -> m.only(BasicTag.class).contains(t2))));
    }
}
