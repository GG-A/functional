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
package com.iofairy.tuple;

/**
 * A tuple of 4 elements<br>
 * 4个元素的元组
 *
 * @param <T1> type of the 1st element.　第1个元素的类型
 * @param <T2> type of the 2nd element.　第2个元素的类型
 * @param <T3> type of the 3rd element.　第3个元素的类型
 * @param <T4> type of the 4th element.　第4个元素的类型
 * @since 0.0.1
 */
public class Tuple4<T1, T2, T3, T4> extends TupleBase {
    private static final long serialVersionUID = 10065918004L;

    /**
     * The 1st element of this tuple.
     */
    public final T1 _1;
    /**
     * The 2nd element of this tuple.
     */
    public final T2 _2;
    /**
     * The 3rd element of this tuple.
     */
    public final T3 _3;
    /**
     * The 4th element of this tuple.
     */
    public final T4 _4;

    /**
     * Constructs a {@code Tuple4}.　Tuple4构造器。
     * @param _1 The value of 1st element
     * @param _2 The value of 2nd element
     * @param _3 The value of 3rd element
     * @param _4 The value of 4th element
     */
    public Tuple4(T1 _1, T2 _2, T3 _3, T4 _4){
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
    }

    @Override
    public int arity() {
        return 4;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Tuple4<T1, T2, T3, T4> alias(TupleAlias... aliases) {
        return (Tuple4<T1, T2, T3, T4>)super.alias(aliases);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Tuple4<T1, T2, T3, T4> alias(String... aliases) {
        return (Tuple4<T1, T2, T3, T4>)super.alias(aliases);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> R element(int n) {
        switch (n) {
            case 0:
                return (R) _1;
            case 1:
                return (R) _2;
            case 2:
                return (R) _3;
            case 3:
                return (R) _4;
            default:
                throw new IndexOutOfBoundsException("Index out of range: " + n + ", Size: " + arity());
        }
    }

}
