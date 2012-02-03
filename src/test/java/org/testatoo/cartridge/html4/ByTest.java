/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.html4;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.testatoo.cartridge.html4.By.$;

public class ByTest {

    private HtmlEvaluator evaluator;
    private String id = "myId";

    @Before
    public void setUp() {
        evaluator = mock(HtmlEvaluator.class);
    }

    @Test
    public void can_find_component_by_jquery() {
        when(evaluator.elementsId("jquery:$('div#content .photo')")).thenReturn(new String[]{id});

        By by = $("$('div#content .photo')");
        by.id(evaluator);
        verify(evaluator, times(1)).elementsId("jquery:$('div#content .photo')");
    }

    @Test
    public void can_find_component_by_jquery_selector() {
        when(evaluator.elementsId("jquery:$('div#content .photo')")).thenReturn(new String[]{id});

        By by = $("div#content .photo");
        by.id(evaluator);
        verify(evaluator, times(1)).elementsId("jquery:$('div#content .photo')");
    }

    @Test
    public void can_find_component_by_$_selector() {
        when(evaluator.elementsId("jquery:$('div#content .photo')")).thenReturn(new String[]{id});

        $("div#content .photo").id(evaluator);
        verify(evaluator, times(1)).elementsId("jquery:$('div#content .photo')");
    }

    @Test
    public void can_find_components_by_jquery() {
        String[] result = {"myId_1", "myId_2", "myId_3"};
        when(evaluator.elementsId("jquery:$('#tableId tr')")).thenReturn(result);

        By by = $("$('#tableId tr')");
        by.ids(evaluator);
        verify(evaluator, times(1)).elementsId("jquery:$('#tableId tr')");
    }

    @Test
    public void can_find_components_by_jquery_selector() {
        String[] result = {"myId_1", "myId_2", "myId_3"};
        when(evaluator.elementsId("jquery:$('#tableId tr')")).thenReturn(result);

        By by = $("#tableId tr");
        by.ids(evaluator);
        verify(evaluator, times(1)).elementsId("jquery:$('#tableId tr')");
    }
}
