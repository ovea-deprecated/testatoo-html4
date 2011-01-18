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

import java.util.Arrays;
import java.util.List;

public abstract class By {

    public static By id(final String id) {
        if (id == null)
            throw new IllegalArgumentException("Cannot find component with a null id.");

        return new By() {
            @Override
            public String id(HtmlEvaluator evaluator) {
                return id;
            }

            @Override
            public List<String> ids(HtmlEvaluator evaluator) {
                return Arrays.asList(id);
            }

            @Override
            public String toString() {
                return "by id=" + id;
            }
        };
    }

    public static By name(final String name) {
        if (name == null)
            throw new IllegalArgumentException("Cannot find component when name is null.");

        return new By() {

            @Override
            public String id(HtmlEvaluator evaluator) {
                return By.xpath("//*[@name='" + name + "']").id(evaluator);
            }

            @Override
            public List<String> ids(HtmlEvaluator evaluator) {
                return By.xpath("//*[@name='" + name + "']").ids(evaluator);
            }

            @Override
            public String toString() {
                return "by name=" + name;
            }
        };
    }

    public static By title(final String title) {
        if (title == null)
            throw new IllegalArgumentException("Cannot find component when title is null.");

        return new By() {

            @Override
            public String id(HtmlEvaluator evaluator) {
                return By.xpath("//*[@title='" + title + "']").id(evaluator);
            }

            @Override
            public List<String> ids(HtmlEvaluator evaluator) {
                return By.xpath("//*[@title='" + title + "']").ids(evaluator);
            }

            @Override
            public String toString() {
                return "by title=" + title;
            }
        };
    }

    public static By xpath(final String xpath) {
        if (xpath == null)
            throw new IllegalArgumentException("Cannot find component when xpath is null.");

        return new By() {

            @Override
            public String id(HtmlEvaluator evaluator) {
                return evaluator.elementId("xpath:" + xpath);
            }

            @Override
            public List<String> ids(HtmlEvaluator evaluator) {
                return Arrays.asList(evaluator.elementsId("xpath:" + xpath));
            }

            @Override
            public String toString() {
                return "by xpath=" + xpath;
            }
        };
    }

    public static By jQuery(final String jQueryExpression) {
        if (jQueryExpression == null)
            throw new IllegalArgumentException("Cannot find component when jQueryExpression is null.");

        return new By() {

            @Override
            public String id(HtmlEvaluator evaluator) {
                return evaluator.elementId("jquery:" + jQueryExpression);
            }

            @Override
            public List<String> ids(HtmlEvaluator evaluator) {
                return Arrays.asList(evaluator.elementsId("jquery:" + jQueryExpression));
            }

            @Override
            public String toString() {
                return "by jQueryExpression=" + jQueryExpression;
            }
        };
    }

    public abstract String id(HtmlEvaluator evaluator);

    public abstract List<String> ids(HtmlEvaluator evaluator);

    public abstract String toString();
}
