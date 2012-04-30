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

import static org.testatoo.cartridge.html4.By.$;

public final class ComponentFactory {

    public static Page page() {
        return new Page(evaluator(), evaluator().pageId());
    }

    public static <T extends Component> T component(Class<T> componentType) {
        if (componentType.equals(AlertBox.class) || componentType.equals(org.testatoo.cartridge.html4.element.AlertBox.class))
            return (T) new org.testatoo.cartridge.html4.element.AlertBox(evaluator());
        else {
            Selection<T> components = findAll(componentType);
            if (components.size() == 1)
                return components.get(0);
            else if (components.size() > 1) {
                throw new ComponentException("Find more than one component for type : " + componentType.getSimpleName());
            } else {
                throw new ComponentException("Cannot find component for type " + componentType.getSimpleName());
            }
        }
    }

    public static <T extends Component> Selection<T> components(Class<T> componentType) {
        //TODO refactor of findAll method
        return findAll(componentType);
    }

    public static <T extends Component> T component(Class<T> componentType, String id) {
        if (id.startsWith("$"))
            //@Deprecated
            return component(componentType, $(id));
        else
            return component(componentType, By.id(id));
    }

    public static <T extends Component> T component(Class<T> componentType, By by) {
        return loadComponent(componentType, by.id(evaluator()));
    }

    public static Selection<? extends Component> components(By by) {
        return components(Component.class, by);
    }

    public static <T extends Component> Selection<T> components(final Class<T> componentType, By by) {
        return ListSelection.from(by.ids(evaluator())).transform(new Function<String, T>() {
            @Override
            public T apply(String id) {
                return loadComponent(componentType, id);
            }
        });
    }

    public static <T extends Component> Selection<T> findAll(Class<T> componentType) {

        if (componentType == Button.class) {
            return ListSelection.compose(
                    components(Button.class, $("input[type=button]")),
                    components(Button.class, $("input[type=reset]")),
                    components(Button.class, $("input[type=submit]")),
                    components(Button.class, $("button")),
                    components(Button.class, $("input:image")))
                    .transform(componentType);
        }

        if (componentType == TextField.class) {
            return components(InputText.class, $("input:text")).transform(componentType);
        }

        if (componentType == PasswordField.class) {
            return components(PasswordField.class, $("input:password")).transform(componentType);
        }

        if (componentType == Field.class) {

            Selection<PasswordField> passwords = ListSelection.empty();
            Selection<TextField> texts = ListSelection.empty();

            try {
                passwords = components(PasswordField.class, $("input:password"));
            } catch (ComponentException e) {
                // Not available in the page so continue
            }

            try {
                texts = components(TextField.class, $("input:text"));
            } catch (ComponentException e) {
                // Not available in the page so continue
            }

            return ListSelection.compose(passwords, texts).transform(componentType);
        }

        if (componentType == Image.class) {
            return components(Image.class, $("img")).transform(componentType);
        }

        if (componentType == Link.class) {
            return components(Link.class, $("a")).transform(componentType);
        }

        if (componentType == Radio.class) {
            return components(Radio.class, $("input:radio")).transform(componentType);
        }

        if (componentType == CheckBox.class) {
            return components(CheckBox.class, $("input:checkbox")).transform(componentType);
        }

        if (componentType == ListBox.class) {
            // TODO see with mathieu
            return (Selection<T>) components(Select.class, $("select"));
        }

        if (componentType == Panel.class) {
            return components(Panel.class, $("div")).transform(componentType);
        }

        // Image
        // Dropdown
        // Combobox
        // Checkbox

        if (componentType == DataGrid.class) {
            return components(DataGrid.class, $("table")).transform(componentType);
        }

        return ListSelection.empty();
    }

    private static HtmlEvaluator evaluator() {
        return EvaluatorHolder.get();
    }

    private static <T extends Component> T loadComponent(Class<T> componentType, String id) {
        Class cmpType = componentType;

        if (componentType.equals(AlertBox.class) || componentType.equals(org.testatoo.cartridge.html4.element.AlertBox.class))
            return (T) new org.testatoo.cartridge.html4.element.AlertBox(evaluator());
        if (componentType.equals(DropDown.class))
            cmpType = org.testatoo.cartridge.html4.element.DropDown.class;
        if (componentType.equals(ListBox.class))
            cmpType = org.testatoo.cartridge.html4.component.ListBox.class;

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
}
