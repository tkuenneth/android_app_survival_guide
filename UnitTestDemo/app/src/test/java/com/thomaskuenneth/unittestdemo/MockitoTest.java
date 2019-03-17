package com.thomaskuenneth.unittestdemo;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    private static final CharSequence HELLO_WORLD = "HELLO WORLD";

    @Mock
    TextView mockTextView;

    @Test
    public void readStringFromContext_LocalizedString() {
        when(mockTextView.getText())
                .thenReturn(HELLO_WORLD);
        CharSequence result = mockTextView.getText();
        assertThat(result, is(HELLO_WORLD));
    }
}
