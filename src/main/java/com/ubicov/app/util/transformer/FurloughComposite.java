/**
 * @Author - Richard Renaud
 * Creates a composite joined class combines GeoLocation with Furlough
 * This class is not persisted and omits the @Entity and @Id annotations.
 */
package com.ubicov.app.util.transformer;

import com.ubicov.app.domain.Furlough;
import com.ubicov.app.domain.GeoLocation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FurloughComposite {
    private GeoLocation geoLoc;
    private Furlough furlough;

    public FurloughComposite(GeoLocation geoLoc, Furlough furlough) {
        this.geoLoc = geoLoc;
        this.furlough = furlough;
    }
}
