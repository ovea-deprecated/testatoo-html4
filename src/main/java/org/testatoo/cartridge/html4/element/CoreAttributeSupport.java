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

package org.testatoo.cartridge.html4.element;

import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.core.component.Component;

/**
 * This class is the implementation of the attributes presented in Coreattrs interface.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#coreattrs">%coreattrs specifications </a>
 */

public final class CoreAttributeSupport {

    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use
     *
     * @param evaluator a UI Test engine specific html evaluator
     */
    CoreAttributeSupport(HtmlEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    /**
     * To get the class attribute of an html element
     *
     * @param component the html element
     * @return the class attribute of the html element
     * @see <a href="http://www.w3.org/TR/html401/struct/global.html#idx-class_attribute"> class specification </a>
     */
    String classname(Component component) {
        return evaluator.attribute(component.id(), Attribute.clazz);
    }

    /**
     * To get the style attribute of an html element
     *
     * @param component the html element
     * @return the style attribute of the html element
     * @see <a href="http://www.w3.org/TR/html401/struct/global.html#idx-class_attribute"> class specification </a>
     */
    String style(Component component) {
        return evaluator.attribute(component.id(), Attribute.style).replace(" ", "").toLowerCase();
    }

    /**
     * To get the title attribute of an html element
     *
     * @param component the html element
     * @return the title attribute of the html element
     * @see <a href="http://www.w3.org/TR/html401/struct/global.html#idx-title-2"> title specification </a>
     */
    String title(Component component) {
        return evaluator.attribute(component.id(), Attribute.title);
    }

}
