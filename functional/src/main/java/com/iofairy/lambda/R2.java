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
 * Represents a function that accepts 2 arguments and produces a result<br>
 * 表示一个接收 2个参数 并返回结果的函数
 *
 * @param <T1> type of the 1st param.　第1个参数类型
 * @param <T2> type of the 2nd param.　第2个参数类型
 * @param <R> return type  返回值类型
 * @since 0.0.1
 */
@FunctionalInterface
public interface R2<T1, T2, R> extends LambdaRN<R>, Lambda2<T1, T2> {
    R $(T1 t1, T2 t2);
}
