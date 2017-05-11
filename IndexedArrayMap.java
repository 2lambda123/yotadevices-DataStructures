/*
 * Copyright (C) 2017 Yota Devices LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import android.support.v4.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link IndexedArrayMap} is a key-value {@link ArrayMap}, which contains a {@link List} of keys.
 * In that way, every key in a map has its own index. It allows to access any key or value by index.
 * Developed to be used in adapters.
 *
 * @author Vitalii Dmitriev
 */
public class IndexedArrayMap<K, V> extends ArrayMap<K, V> {
    /**
     * List of map's keys.
     */
    private List<K> mKeyList;

    public IndexedArrayMap() {
        super();
        mKeyList = new ArrayList<>();
    }

    public IndexedArrayMap(int capacity) {
        super(capacity);
        mKeyList = new ArrayList<>(capacity);
    }

    @Override
    public V put(K key, V value) {
        mKeyList.add(key);
        return super.put(key, value);
    }

    /**
     * Returns the key in position.
     *
     * @param position index of the requested key.
     * @return the key in position.
     */
    public K getKey(int position) {
        return mKeyList.get(position);
    }

    /**
     * Returns the value by key's position.
     *
     * @param position index of the key for a requested value.
     * @return the value in key's position.
     */
    public V getValue(int position) {
        return get(getKey(position));
    }
}
