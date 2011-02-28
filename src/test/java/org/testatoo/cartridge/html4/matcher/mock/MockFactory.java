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

package org.testatoo.cartridge.html4.matcher.mock;

import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.cartridge.html4.element.*;
import org.testatoo.core.ListSelection;
import org.testatoo.core.Selection;
import org.testatoo.core.component.Component;
import org.testatoo.core.component.ListModel;

import static org.mockito.Mockito.*;

public class MockFactory {

    public static Select selectWith2OptionGroups() {
        HtmlEvaluator evaluator = mock(HtmlEvaluator.class);

        String id = "myId";
        String opt_1_id = "option1";
        String opt_2_id = "option2";
        String optGrp_1_id = "optGrp_1";
        String optGrp_2_id = "optGrp_2";

        when(evaluator.existComponent(any(String.class))).thenReturn(true);
        when(evaluator.isVisible(any(Component.class))).thenReturn(true);
        when(evaluator.isEnabled(any(Component.class))).thenReturn(true);

        when(evaluator.htmlElementType(opt_1_id)).thenReturn(HtmlElementType.Option);
        when(evaluator.htmlElementType(opt_2_id)).thenReturn(HtmlElementType.Option);
        when(evaluator.htmlElementType(optGrp_1_id)).thenReturn(HtmlElementType.OptionGroup);
        when(evaluator.htmlElementType(optGrp_2_id)).thenReturn(HtmlElementType.OptionGroup);

        when(evaluator.label(any(Option.class))).thenReturn("labelOption");
        when(evaluator.label(any(OptionGroup.class))).thenReturn("labelOptionGrp");

        when(evaluator.content(any(Option.class))).thenReturn("text");

        when(evaluator.selected(any(Option.class))).thenReturn(false);
        when(evaluator.attribute(id, Attribute.size)).thenReturn("2");

        OptionGroup optionGroup_1 = new OptionGroup(evaluator, optGrp_1_id);
        OptionGroup optionGroup_2 = new OptionGroup(evaluator, optGrp_2_id);
        Option option_1 = new Option(evaluator, opt_1_id);
        Option option_2 = new Option(evaluator, opt_2_id);

        Selection<Option> options_1 = ListSelection.of(option_1);
        Selection<Option> options_2 = ListSelection.of(option_2);

        when(evaluator.options(any(Select.class))).thenReturn(ListSelection.<Option>empty());
        when(evaluator.selectedOptions(any(Select.class))).thenReturn(ListSelection.<Option>empty());

        when(evaluator.options(optionGroup_1)).thenReturn(options_1);
        when(evaluator.options(optionGroup_2)).thenReturn(options_2);

        Selection<OptionGroup> optionGroups = ListSelection.of(optionGroup_1, optionGroup_2);

        when(evaluator.optionGroups(any(Select.class))).thenReturn(optionGroups);

        return new Select(evaluator, id);
    }

    public static Select selectWith3Options() {
        HtmlEvaluator evaluator = mock(HtmlEvaluator.class);

        String id = "myId";
        String opt_1_id = "option1";
        String opt_2_id = "option2";
        String opt_3_id = "option3";

        when(evaluator.existComponent(any(String.class))).thenReturn(true);
        when(evaluator.isVisible(any(Component.class))).thenReturn(true);
        when(evaluator.isEnabled(any(Component.class))).thenReturn(true);

        when(evaluator.htmlElementType(any(String.class))).thenReturn(HtmlElementType.Option);
        when(evaluator.label(any(Option.class))).thenReturn("label");
        when(evaluator.content(any(Option.class))).thenReturn("text");
        when(evaluator.selected(any(Option.class))).thenReturn(false);
        when(evaluator.attribute(id, Attribute.size)).thenReturn("2");

        Option option_1 = new Option(evaluator, opt_1_id);
        Option option_2 = new Option(evaluator, opt_2_id);
        Option option_3 = new Option(evaluator, opt_3_id);

        when(evaluator.optionGroups(any(Select.class))).thenReturn(ListSelection.<OptionGroup>empty());
        when(evaluator.value(option_1)).thenReturn("UK");
        when(evaluator.value(option_2)).thenReturn("Canada");
        when(evaluator.value(option_3)).thenReturn("Italy");

        Selection<String> values = ListSelection.of("UK", "Canda", "Italy");

        when(evaluator.values(any(ListModel.class))).thenReturn(values);

        Selection<String> selectedValues = ListSelection.of("UK", "Italy");

        when(evaluator.selectedValues(any(ListModel.class))).thenReturn(selectedValues);

        Selection<Option> selectedOptions = ListSelection.of(option_1, option_3);

        when(evaluator.selectedOptions(any(Select.class))).thenReturn(selectedOptions);

        Selection<Option> options = ListSelection.of(option_1, option_2, option_3);
        when(evaluator.options(any(Select.class))).thenReturn(options);

        return new Select(evaluator, id);
    }

}
