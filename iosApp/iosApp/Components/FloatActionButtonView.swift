//
//  FloatActionButtonView.swift
//  iosApp
//
//  Created by Harold Jose Barros Gonçalves on 02/05/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct FloatActionButtonView: View {
    var image:String
    var action: ()->()
    var body: some View {
        Button(action: {
            self.action()
        }, label: {
                Image(systemName:image)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 40, height: 40)
                    .cornerRadius(3.0)
                    .padding(8)
        })
        .background(Color.white)
        .cornerRadius(38.5)
        .shadow(color: Color.black.opacity(0.3),
                radius: 6,
                x: 3,
                y: 3)
    }
}

struct FloatActionButtonView_Previews: PreviewProvider {
    static var previews: some View {
        FloatActionButtonView(image: "bus") {
            //action
        }
    }
}
