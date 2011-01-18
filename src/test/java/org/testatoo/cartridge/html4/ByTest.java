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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ByTest {

    private HtmlEvaluator evaluator;
    private String id = "myId";

    @Before
    public void setUp() {
        evaluator = mock(HtmlEvaluator.class);
    }

    @Test
    public void can_find_component_by_id_always_return_the_is_passed() {
        By by = By.id(id);
        assertEquals(id, by.id(evaluator));
    }

    @Test
    public void can_find_components_by_id() {
        By by = By.id(id);

        List<String> cmpIds = by.ids(evaluator);
        assertEquals(cmpIds.size(), 1);
        assertEquals(cmpIds.get(0), id);
    }

    // ----------------------------------------------------------------------------------------------

    @Test
    public void can_find_component_by_xpath() {
        when(evaluator.elementId("xpath://button[@name='test']")).thenReturn(id);

        By by = By.xpath("//button[@name='test']");
        by.id(evaluator);

        verify(evaluator, times(1)).elementId("xpath://button[@name='test']");

    }

    @Test
    public void can_find_components_by_xpath() {
        String[] result = {"myId_1", "myId_2", "myId_3"};
        when(evaluator.elementsId("xpath://button[@name='test']")).thenReturn(result);

        By by = By.xpath("//button[@name='test']");
        by.ids(evaluator);
        verify(evaluator, times(1)).elementsId("xpath://button[@name='test']");
    }

    // ----------------------------------------------------------------------------------------------

    @Test
    public void can_find_component_by_jquery() {

        when(evaluator.elementId("jquery:div#content .photo")).thenReturn(id);

        By by = By.jQuery("div#content .photo");
        by.id(evaluator);
        verify(evaluator, times(1)).elementId("jquery:div#content .photo");
    }

    @Test
    public void can_find_components_by_jquery() {
        String[] result = {"myId_1", "myId_2", "myId_3"};
        when(evaluator.elementsId("jquery:#tableId tr")).thenReturn(result);

        By by = By.jQuery("#tableId tr");
        by.ids(evaluator);
        verify(evaluator, times(1)).elementsId("jquery:#tableId tr");

    }
}
