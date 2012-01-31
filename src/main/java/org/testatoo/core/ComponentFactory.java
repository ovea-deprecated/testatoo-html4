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

package org.testatoo.core;

import com.google.common.base.Function;
import org.testatoo.cartridge.html4.By;
import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.cartridge.html4.element.InputText;
import org.testatoo.cartridge.html4.element.Select;
import org.testatoo.core.component.*;
import org.testatoo.core.component.datagrid.DataGrid;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public final class ComponentFactory {

    public static Page page() {
        return new Page(evaluator(), evaluator().pageId());
    }

    @Deprecated
    public static <T extends Component> T component(Class<T> componentType, String id) {
        if (id.startsWith("$"))
            return component(componentType, By.jQuery(id));
        else
            return component(componentType, By.id(id));
    }

    public static <T extends Component> T component(Class<T> componentType, By by) {
        Class cmpType = componentType;

        if (componentType.equals(AlertBox.class) || componentType.equals(org.testatoo.cartridge.html4.element.AlertBox.class))
            return (T) new org.testatoo.cartridge.html4.element.AlertBox(evaluator());
        if (componentType.equals(DropDown.class))
            cmpType = org.testatoo.cartridge.html4.element.DropDown.class;
        if (componentType.equals(ListBox.class))
            cmpType = org.testatoo.cartridge.html4.component.ListBox.class;

        final String id;
        try {
            id = by.id(evaluator());
        } catch (Exception e) {
            throw new ComponentException("Cannot find component defined " + by, e);
        }
        try {
            return (T) cmpType.getConstructor(HtmlEvaluator.class, String.class).newInstance(evaluator(), id);
        } catch (Exception e) {
            if (e.getCause() instanceof ComponentException)
                throw (ComponentException) e.getCause();
            try {
                return componentType.getConstructor(Evaluator.class, String.class).newInstance(evaluator(), id);
            } catch (InvocationTargetException ite) {
                throw new ComponentException(ite.getTargetException().getMessage(), ite.getTargetException());
            } catch (Exception e1) {
                throw new ComponentException(e1.getMessage(), e1);
            }
        }
    }

    public static Selection<? extends Component> components(By by) {
        final List<String> ids;
        try {
            ids = by.ids(evaluator());
        } catch (Exception e) {
            throw new ComponentException("Cannot find component defined " + by, e);
        }
        return ListSelection.from(ids).transform(new Function<String, Component>() {
            @Override
            public Component apply(String id) {
                return component(Component.class, id);
            }
        });
    }

    public static <T extends Component> Selection<T> components(Class<T> componentType, By by) {
        final List<String> ids;
        final List<Component> components = new ArrayList<Component>();

        try {
            ids = by.ids(evaluator());
        } catch (Exception e) {
            throw new ComponentException("Cannot find component defined " + by, e);
        }

        for (String id : ids) {
            components.add(component(componentType, id));
        }

        return ListSelection.from(components).transform(componentType);
    }


    public static <T extends Component> Selection<T> findAll(Class<T> componentType) {
        if (componentType == Button.class) {
            return ListSelection.compose(
                    components(Button.class, By.jQuery("$('input[type=button]')")),
                    components(Button.class, By.jQuery("$('input[type=reset]')")),
                    components(Button.class, By.jQuery("$('input[type=submit]')")),
                    components(Button.class, By.jQuery("$('button')")),
                    components(Button.class, By.jQuery("$('input:image')")))
                    .transform(componentType);
        }

        if (componentType == TextField.class) {
            return components(InputText.class, By.jQuery("$('input:text')")).transform(componentType);
        }

        if (componentType == PasswordField.class) {
            return components(PasswordField.class, By.jQuery("$('input:password')")).transform(componentType);
        }

        if (componentType == Field.class) {

            Selection<PasswordField> passwords = ListSelection.empty();
            Selection<TextField> texts = ListSelection.empty();

            try {
                passwords = components(PasswordField.class, By.jQuery("$('input:password')"));
            } catch (ComponentException e) {
                // Not available in the page so continue
            }

            try {
                texts = components(TextField.class, By.jQuery("$('input:text')"));
            } catch (ComponentException e) {
                // Not available in the page so continue
            }

            return ListSelection.compose(passwords, texts).transform(componentType);
        }

        if (componentType == Image.class) {
            return components(Image.class, By.jQuery("$('img')")).transform(componentType);
        }

        if (componentType == Link.class) {
            return components(Link.class, By.jQuery("$('a')")).transform(componentType);
        }

        if (componentType == Radio.class) {
            return components(Radio.class, By.jQuery("$('input:radio')")).transform(componentType);
        }

        if (componentType == CheckBox.class) {
            return components(CheckBox.class, By.jQuery("$('input:checkbox')")).transform(componentType);
        }

        if (componentType == ListBox.class) {
            // TODO see with mathieu
            return (Selection<T>) components(Select.class, By.jQuery("$('select')"));
        }

        //TODO test
        if (componentType == Panel.class) {
            return components(Panel.class, By.jQuery("$('div9)")).transform(componentType);
        }

        // Image
        // Dropdown
        // Combobox
        // Checkbox

        if (componentType == DataGrid.class) {
            return components(DataGrid.class, By.jQuery("$('table')")).transform(componentType);
        }

        return ListSelection.empty();
    }

    private static HtmlEvaluator evaluator() {
        return EvaluatorHolder.get();
    }

}
