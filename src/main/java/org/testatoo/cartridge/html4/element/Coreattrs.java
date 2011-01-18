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

/**
 * This interface allows to test the value of coreattrs attributes on html tags.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#coreattrs">%coreattrs specifications </a>
 */
public interface Coreattrs {

    /**
     * To get the id attribute (unique) of an html element.
     *
     * @return the id attribute of the html element
     */
    String id();

    /**
     * To get the class attribute of an html element
     *
     * @return the class attribute of the html element.
     * @see CoreAttributeSupport
     */
    String classname();

    /**
     * To get the style attribute of an html element
     *
     * @return the style attribute of the html element.
     * @see CoreAttributeSupport
     */
    String style();

    /**
     * To get the title attribute of an html element
     *
     * @return the title attribute of the html element.
     * @see CoreAttributeSupport
     */
    String title();

}
