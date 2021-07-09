/*
 * Copyright (C) 2021 iofairy, <https://github.com/io-fairy/functional>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.iofairy.lambda;

/**
 * Represents a function that accepts 0 argument and produces a result, and will throw exception<br>
 * 表示一个不接收任何参数，但返回结果且抛出异常的函数
 *
 * @param <R> return type  返回值类型
 * @param <E> Throwable or subclass of Throwable.　Throwable类及其子类
 * @since 0.0.1
 */
@FunctionalInterface
public interface RT0<R, E extends Throwable> extends LambdaRT<R, E>, Lambda0 {
    R $() throws E;
}
