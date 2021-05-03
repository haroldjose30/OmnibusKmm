//
//  AnnotatedItem.swift
//  iosApp
//
//  Created by Harold Jose Barros Gonçalves on 02/05/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import MapKit

struct AnnotatedItem: Identifiable {
    let id = UUID()
    var number: String
    var name: String
    var image:String
    var coordinate: CLLocationCoordinate2D
}
